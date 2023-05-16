package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rockpaperscissors.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors;
    TextView tv_score,textView;
    ImageView iv_cpu, iv_me;
    int myScore = 0, cpuScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        tv_score = (TextView) findViewById(R.id.tv_score);
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);
        textView=(TextView) findViewById(R.id.textView);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_me.setImageResource(R.drawable.rock);
                String result = play("rock");
                if (result.equals("win")) {
                    myScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else if (result.equals("lose")) {
                    cpuScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else {
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                }
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_me.setImageResource(R.drawable.paper);
                String result = play("paper");
                if (result.equals("win")) {
                    myScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else if (result.equals("lose")) {
                    cpuScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else {
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                }
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_me.setImageResource(R.drawable.scissors);
                String result = play("scissors");
                if (result.equals("win")) {
                    myScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else if (result.equals("lose")) {
                    cpuScore++;
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                } else {
                    tv_score.setText("Score : Me " + myScore + " CPU " + cpuScore +"  ");
                }
            }
        });
    }

    public String play(String playerChoice) {
        String cpuChoice = "";
        Random r = new Random();
        int cpu = r.nextInt(3) + 1;

        if (cpu == 1) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 2) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 3) {
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if (cpuChoice.equals(playerChoice)) {
            return "draw";
        } else if (cpuChoice.equals("rock") && playerChoice.equals("scissors")) {
            return "lose";
        } else if (cpuChoice.equals("paper") && playerChoice.equals("rock")) {
            return "lose";
        } else if (cpuChoice.equals("scissors") && playerChoice.equals("paper")) {
            return "lose";
        } else {
            return "win";
        }
    }
}