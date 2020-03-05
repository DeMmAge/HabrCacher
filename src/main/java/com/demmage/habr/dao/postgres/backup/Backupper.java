package com.demmage.habr.dao.postgres.backup;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Backupper {

    private OkHttpClient client = new OkHttpClient();

    public boolean backup() {
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .build();
        Request request = new Request.Builder()
                .url("https://api.elephantsql.com/api/backup")
                .header("Authorization", "f35925cb-13c4-436c-af18-dc58faea08ed")
//                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.code() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
