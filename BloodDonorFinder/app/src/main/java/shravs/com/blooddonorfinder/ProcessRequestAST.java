package shravs.com.blooddonorfinder;

import android.os.AsyncTask;

/**
 * Created by S519351 on 11/30/2014.
 */
public class ProcessRequestAST extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String identifier = params[0];
        if(identifier.equals("Register")) {

        }

        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }
}
