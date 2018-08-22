package projeto.heaven.audio;

import android.content.Context;

import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

public class Falar {

    private TextToSpeech tts;
    private Context contexto;

    public Falar(Context contexto){
        this.contexto = contexto;
    }

    public void falar(final String texto){


        tts = new TextToSpeech(contexto, new TextToSpeech.OnInitListener() {


            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int res = tts.setLanguage(new Locale("pt", "BR"));
                    if (res >= TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(contexto, texto, Toast.LENGTH_SHORT).show();
                        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);

                    }
                }
            }

        });

    }

}

