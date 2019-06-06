package nl.hva.msi.eventplanner.ui.logic;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * This class is used to fetch images async
 */
public class ImageStream extends AsyncTask<String, Void, Bitmap> {

    @SuppressLint("StaticFieldLeak")
    private ImageView bmImage;

    public ImageStream(ImageView imageView){
        this.bmImage = imageView;
    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        String urldisplay = strings[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
            in.close();
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }


}
