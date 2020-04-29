package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StageActivity extends AppCompatActivity  {
    private int stageid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        View[] buttons = new View[5];
        Bundle b = getIntent().getExtras();
        stageid = b.getInt("stageid");
        for(int i=1;i<6;i++){
            int btn=getResources().getIdentifier("stage"+i,"id",getPackageName());
            final int finalI = i;
            buttons[i-1]=findViewById(btn);
            buttons[i-1].setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                    Bundle b = new Bundle();
                    stageid+= finalI;
                    b.putInt("stageid", stageid); // Your score
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });

        }

    }




}
