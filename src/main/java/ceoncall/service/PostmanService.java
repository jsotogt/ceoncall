package ceoncall.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class PostmanService
{

    /**
     * Sends an HTTP POST request to the given URL.
     *
     * @param targetUrl
     *          the URL to use to send the request
     * @param request
     *          the request to use
     * @return the HTTP response
     */
    public String send(String targetUrl, String request)
    {
        // HTTP connection
        HttpURLConnection urlConnection = null;

        try
        {
            // apprend http prefix to url
            targetUrl = "http://" + targetUrl;

            // create HTTP connection
            URL url = new URL(targetUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");

            // configure connection
            urlConnection.setDoOutput(true);

            // send request
            OutputStream outputStream = null;
            try
            {
                outputStream = urlConnection.getOutputStream();
                outputStream.write(request.getBytes());
                outputStream.flush();
            }
            finally
            {
                if (outputStream != null)
                    outputStream.close();
            }

            // get response
            StringBuilder response = new StringBuilder();
            InputStream inputStream = null;
            try
            {
                inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    response.append(line);
                }
            }
            finally
            {
                if (inputStream != null)
                    inputStream.close();
            }

            // return response
            return response.toString();
        }
        catch (IOException ex)
        {
            return ex.getMessage();
        }
        finally
        {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }
}