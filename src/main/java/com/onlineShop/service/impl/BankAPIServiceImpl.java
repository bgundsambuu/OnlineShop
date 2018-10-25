package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.service.BankAPIService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BankAPIServiceImpl implements BankAPIService {

    private String sendPOST(String POST_URL) throws IOException {
        URL obj = new URL(POST_URL);
        String POST_PARAMS = "";
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            try {
                String responses = response.toString();
                System.out.println(responses);
                JSONObject object = new JSONObject(responses);
                return object.getString("code");
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                return "200";
            }
        }
        return "404";
    }

    @Override
    public int callBankAPI(String cardNo, String expiredMonth, String expiredYear, String cvv, String ownerName, String zipCode, String purchaseAmnt) {
        String url = "http://localhost:5555/api/v1/payment/card-no/"+cardNo+
                "/expired-mm/"+expiredMonth+"/expired-yyyy/"+expiredYear+"/cvv/"+cvv+"/owner-name/"+ownerName+"/zip-code/"+zipCode+"/purchase-amt/"+purchaseAmnt;
        try {
            System.out.println(url);
            String s = sendPOST(url);
            System.out.println(s);
            return 200;
            //return sendPOST(url);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return 200;
        }
    }
}
