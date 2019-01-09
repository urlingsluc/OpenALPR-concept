package main.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.exceptions.CannotDetectException;
import main.exceptions.NoServiceException;
import main.model.License;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
@Service
public class LicenseService {
    private static final String KEY = "sk_0013c2d28059428fddf3ced2";

    private String sendRequest(byte[] inputBytes) throws NoServiceException {
        try
        {
            // Encode file bytes to base64
            byte[] encoded = Base64.getEncoder().encode(inputBytes);

            // Setup the HTTPS connection to api.openalpr.com
            URL url = new URL("https://api.openalpr.com/v2/recognize_bytes?recognize_vehicle=1&country=eu&secret_key=" + KEY);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setFixedLengthStreamingMode(encoded.length);
            http.setDoOutput(true);

            // Send our Base64 con tent over the stream
            try(OutputStream os = http.getOutputStream()) {
                os.write(encoded);
            }

            int status_code = http.getResponseCode();
            if (status_code == 200)
            {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        http.getInputStream()));
                String json_content = "";
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    json_content += inputLine;
                in.close();
                
                return json_content;
            }
            else
            {
                throw new NoServiceException();
            }


        }
        catch (Exception e )
        {
           throw new NoServiceException();
        }
    }

    public License getPlate(byte[] fileBytes) throws NoServiceException, CannotDetectException {
        String jsonString = sendRequest(fileBytes);
        try {
            JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
            JsonObject result = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject();

            String plate = result.get("plate").getAsString();
            float confidence = result.get("confidence").getAsFloat();
            License license = new License(plate, confidence);
            if (confidence < 60f){
                throw new CannotDetectException();
            }
            return license;
        } catch (Exception e){
            throw new NoServiceException();
        }
    }
}
