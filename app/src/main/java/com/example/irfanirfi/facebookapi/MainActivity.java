//package com.example.irfanirfi.facebookapi;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
////import com.facebook.AccessToken;
////import com.facebook.AccessTokenTracker;
////import com.facebook.CallbackManager;
////import com.facebook.FacebookCallback;
////import com.facebook.FacebookException;
////import com.facebook.FacebookSdk;
////import com.facebook.Profile;
////import com.facebook.ProfileTracker;
////import com.facebook.appevents.AppEventsLogger;
////import com.facebook.login.LoginResult;
////import com.facebook.login.widget.LoginButton;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import static android.R.attr.bitmap;
//import static java.security.AccessController.getContext;
//
//public class MainActivity extends AppCompatActivity {
//
//    private CallbackManager callbackManager;
//    private ProfileTracker profileTracker;
//    private AccessTokenTracker accessTokenTracker;
//    TextView t;
//    Bitmap bmp;
//    Uri profilePictureUrl;
//    String pfUrl = "";
//    ImageView iv;
//    String user_id = "";
//    String firstname = "",lastname = "";
//
//    LoginButton button;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//            t = (TextView) findViewById(R.id.text);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
//        callbackManager = CallbackManager.Factory.create();
//        button = (LoginButton) findViewById(R.id.fbbutton);
//        iv  = (ImageView) findViewById(R.id.imageView);
//
//
//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//
//            }
//        };
//
//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                firstname = currentProfile.getFirstName();
//
//               lastname = currentProfile.getLastName();
//
//                String middlename = currentProfile.getMiddleName();
//                String user_id = currentProfile.getId();
//                t.setText(firstname+ " "+lastname+"\n "+user_id);
//
//                profilePictureUrl =  currentProfile.getProfilePictureUri(100,100);
//               // iv.setImageURI(profilePicture);
//                Toast.makeText(MainActivity.this,profilePictureUrl.toString(),Toast.LENGTH_LONG).show();
//                new DownloadProfileImage().execute(profilePictureUrl.toString());
//
//                CheckFbUser();
//            }
//        };
//
//        accessTokenTracker.startTracking();
//        profileTracker.startTracking();
//
//
//        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        };
//
//
//        button.setReadPermissions("user_friends");
//        button.registerCallback(callbackManager,callback);
//
//
//
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }
//
//    private  class DownloadProfileImage extends AsyncTask<String,Void,Bitmap> {
//        Bitmap MIcon;
//
//
//
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//
//            String url = strings[0];
//
//
//
//
//            try{
//                InputStream in = new java.net.URL(url).openStream();
//                MIcon = BitmapFactory.decodeStream(in);
//            }catch(Exception e)
//            {
//
//            }
//                return MIcon;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
//            iv.setImageBitmap(bitmap);
//
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//
//            }
//        };
//
//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                String firstname = currentProfile.getFirstName();
//
//                String lastname = currentProfile.getLastName();
//
//                String middlename = currentProfile.getMiddleName();
//                user_id = currentProfile.getId();
//                t.setText(firstname+ " "+lastname+"\n "+user_id);
//
//                profilePictureUrl =  currentProfile.getProfilePictureUri(100,100);
//                // iv.setImageURI(profilePicture);
//                Toast.makeText(MainActivity.this,profilePictureUrl.toString(),Toast.LENGTH_LONG).show();
//                new DownloadProfileImage().execute(profilePictureUrl.toString());
//            }
//        };
//
//        accessTokenTracker.startTracking();
//        profileTracker.startTracking();
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//
//            }
//        };
//
//        profileTracker = new ProfileTracker() {
//            @Override
//            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
//                String firstname = currentProfile.getFirstName();
//
//                String lastname = currentProfile.getLastName();
//
//                String middlename = currentProfile.getMiddleName();
//                String user_id = currentProfile.getId();
//                t.setText(firstname+ " "+lastname+"\n "+user_id);
//
//                profilePictureUrl =  currentProfile.getProfilePictureUri(100,100);
//                // iv.setImageURI(profilePicture);
//                //Toast.makeText(MainActivity.this,profilePictureUrl.toString(),Toast.LENGTH_LONG).show();
//                new DownloadProfileImage().execute(profilePictureUrl.toString());
//            }
//        };
//
//        accessTokenTracker.startTracking();
//        profileTracker.startTracking();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        accessTokenTracker.stopTracking();
//        profileTracker.stopTracking();
//    }
//
//    private void CheckFbUser()
//    {
//        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.199.2/AndroidFiles/login.php", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONObject object = new JSONObject(response);
//                    Boolean User = object.getBoolean("error");
//                    String msg = object.getString("message");
//                    if(User)
//                    {
//                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
//                    }
//                    else
//                    {
//                        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
//                        i.putExtra("username",firstname+" "+lastname);
//                        startActivity(i);
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//
//    }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//
//                Map<String, String> params = new HashMap<>();
//                params.put("user_id",user_id);
//
//                return params;
//
//
//            }
//        };
//
//        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
//        rq.add(request);
//    }
//}
