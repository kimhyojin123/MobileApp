//package hitesh.asimplegame;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_question);
//    }
//}
package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private int stageid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button btn1=(Button) findViewById(R.id.button1);
//        btn1.setOnClickListener(this);
//        Button btn2=(Button) findViewById(R.id.button2);
//        btn2.setOnClickListener(this);
//        Button btn3=(Button) findViewById(R.id.button3);
//        btn3.setOnClickListener(this);
        View[] buttons = new View[3];
        for (int i = 1; i < 4; i++) {
            int btn = getResources().getIdentifier("button" + i, "id", getPackageName());
            final int finalI = i;
            buttons[i - 1] = findViewById(btn);
            buttons[i - 1].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), StageActivity.class);
                    Bundle b = new Bundle();
                    stageid = finalI * 10;
                    b.putInt("stageid", stageid); // Your score
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });
        }
    }
}

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(getApplicationContext(), StageActivity.class);
//        int btn=getResources().getIdentifier("button"+i,"id",getPackageName());
//        stageid=i*10;
//        Bundle b = new Bundle();
//        b.putInt("stageid", stageid); // Your score
//        intent.putExtras(b);
//        startActivity(intent);
//
//
//}
