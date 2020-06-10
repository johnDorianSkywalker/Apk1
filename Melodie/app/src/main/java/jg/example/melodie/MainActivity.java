package jg.example.melodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.Button;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final int sound1 = R.raw.fx1;
    public static final int sound2 = R.raw.fx2;
    public static final int sound3 = R.raw.fx3;
    public static final int sound4 = R.raw.fx4;
    public static final int sound5 = R.raw.fx5;
    public static final int sound6 = R.raw.fx6;

    Button dzwiek1;
    Button dzwiek2;
    Button dzwiek3;
    Button dzwiek4;
    Button dzwiek5;
    Button dzwiek6;

    static final int READ_BLOCK_SIZE = 6;

    public void playSound(Context context, int SoundID) {
        MediaPlayer mp = MediaPlayer.create(context, SoundID);
        mp.start();
    }

    TextView textViewSekwencja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dzwiek1 = (Button) findViewById(R.id.buttonSound1);
        dzwiek2 = (Button) findViewById(R.id.buttonSound2);
        dzwiek3 = (Button) findViewById(R.id.buttonSound3);
        dzwiek4 = (Button) findViewById(R.id.buttonSound4);
        dzwiek5 = (Button) findViewById(R.id.buttonSound5);
        dzwiek6 = (Button) findViewById(R.id.buttonSound6);

        textViewSekwencja = (TextView) findViewById(R.id.textViewSekwencja);
    }

    public void GrajSound_1 (View v) {
        int sound = 0;
        if (dzwiek1.getId() == v.getId()) {
            sound = sound1;
            dzwiek1.setBackgroundColor(Color.GREEN);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
        }
        else if(dzwiek2.getId() == v.getId()) {
            sound = sound2;
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.GREEN);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
        }
        else if(dzwiek3.getId() == v.getId()) {
            sound = sound3;
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.GREEN);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
        }
        else if(dzwiek4.getId() == v.getId()) {
            sound = sound4;
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.GREEN);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
        }
        else if(dzwiek5.getId() == v.getId()) {
            sound = sound5;
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.GREEN);
            dzwiek6.setBackgroundColor(Color.RED);
        }
        else if(dzwiek6.getId() == v.getId()) {
            sound = sound6;
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.GREEN);
        }
        playSound(this,sound);
    }

    public void SaveBtn (View v){
        try {
            FileOutputStream fo = openFileOutput("plik.txt", MODE_PRIVATE);
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            ow.write("ABCDEF");
            ow.close();

            Toast.makeText(getBaseContext(), "Zapisano sekwencje", Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadBtn (View v) {
        try {
            FileInputStream fi = openFileInput("plik.txt");
            InputStreamReader ir = new InputStreamReader(fi);
            char[] inputBuffer = new char [READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while((charRead=ir.read(inputBuffer))>0) {
                String readstring = String.copyValueOf(inputBuffer,0,charRead);
                s += readstring;
            }
            ir.close();
            Toast.makeText(getBaseContext(), "Wczytano sekwencje", Toast.LENGTH_SHORT).show();
            textViewSekwencja.setText(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playAllBtn(View v) {
        try {
            FileInputStream fi = openFileInput("plik.txt");
            InputStreamReader ir = new InputStreamReader(fi);
            char[] inputBuffer = new char [READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while((charRead=ir.read(inputBuffer))>0) {
                String readstring = String.copyValueOf(inputBuffer,0,charRead);
                s += readstring;
            }
            ir.close();
            int sound = 0;
            for (int i = 0; i < s.length() ;i++) {
                if (s.charAt(i)=='A') {
                    sound = sound1;
                }
                else if (s.charAt(i)=='B') {
                    sound = sound2;
                }
                else if (s.charAt(i)=='C') {
                    sound = sound3;
                }
                else if (s.charAt(i)=='D') {
                    sound = sound4;
                }
                else if (s.charAt(i)=='E') {
                    sound = sound5;
                }
                else if (s.charAt(i)=='F') {
                    sound = sound6;
                }
                playSound(this,sound);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}