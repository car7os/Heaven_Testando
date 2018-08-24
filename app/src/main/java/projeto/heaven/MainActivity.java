package projeto.heaven;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projeto.heaven.audio.Falar;


public class MainActivity extends AppCompatActivity {

    private static Intent intent;
    private static final int REQUEST_CODE = 1001;
    private static Falar out;
    private static ArrayList<String> matches = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         out = new Falar(getApplicationContext());

        verificarEntradaAudio();

            while(ouvir()==null){

            }



    }

    public void verificarEntradaAudio(){
        // Check if voice recognition is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            Toast.makeText(this, "Voice recognizer not present", Toast.LENGTH_SHORT).show();
        }else {

            intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);

            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale Agora");

            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);


        }

    }

    public String ouvir(){

        String retorno = null;
        retorno = matches.get(0);
        matches.clear();
                startActivityForResult(intent, REQUEST_CODE);

                return retorno;
    }

    protected void onActivityForResult(
            int requestCode, int resultCode, Intent data) {


            if (requestCode == REQUEST_CODE
                    && resultCode == RESULT_OK) {

                // Contém a lista com os resultados

                matches =
                        data.getStringArrayListExtra(
                                RecognizerIntent.EXTRA_RESULTS);
                Toast.makeText(this, matches.get(0), Toast.LENGTH_SHORT).show();

            }
    }




}
