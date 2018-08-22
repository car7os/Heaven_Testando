package projeto.heaven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import projeto.heaven.audio.Falar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Falar out = new Falar(getApplicationContext());
        out.falar("Olá Mundo!");
    }
}
