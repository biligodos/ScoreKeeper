package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.scorekeeper.R.id.team_a_corner;
import static com.example.android.scorekeeper.R.id.team_a_exclusion;
import static com.example.android.scorekeeper.R.id.team_a_foul;
import static com.example.android.scorekeeper.R.id.team_a_penalty;
import static com.example.android.scorekeeper.R.id.team_a_score;
import static com.example.android.scorekeeper.R.id.team_b_corner;
import static com.example.android.scorekeeper.R.id.team_b_exclusion;
import static com.example.android.scorekeeper.R.id.team_b_foul;
import static com.example.android.scorekeeper.R.id.team_b_penalty;
import static com.example.android.scorekeeper.R.id.team_b_score;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int cornerTeamA = 0;
    int foulTeamA = 0;
    int exclusionTeamA = 0;
    int penaltyTeamA = 0;
    int scoreTeamB = 0;
    int cornerTeamB = 0;
    int foulTeamB = 0;
    int exclusionTeamB = 0;
    int penaltyTeamB = 0;

    EditText nameTeamA;
    EditText nameTeamB;
    TextView scoreViewA;
    TextView cornerViewA;
    TextView foulViewA;
    TextView exclusionViewA;
    TextView penaltyViewA;
    TextView scoreViewB;
    TextView cornerViewB;
    TextView foulViewB;
    TextView exclusionViewB;
    TextView penaltyViewB;
    String strNameTeamA;
    String strNameTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTeamA = (EditText) findViewById(R.id.team_a_name);
        if (savedInstanceState != null) {
            nameTeamA.setText(savedInstanceState.getString(strNameTeamA));
        }

        nameTeamB = (EditText) findViewById(R.id.team_b_name);
        if (savedInstanceState != null) {
            nameTeamB.setText(savedInstanceState.getString(strNameTeamB));
        }

        scoreViewA = (TextView) findViewById(team_a_score);
        cornerViewA = (TextView) findViewById(team_a_corner);
        foulViewA = (TextView) findViewById(team_a_foul);
        exclusionViewA = (TextView) findViewById(team_a_exclusion);
        penaltyViewA = (TextView) findViewById(team_a_penalty);
        scoreViewB = (TextView) findViewById(team_b_score);
        cornerViewB = (TextView) findViewById(team_b_corner);
        foulViewB = (TextView) findViewById(team_b_foul);
        exclusionViewB = (TextView) findViewById(team_b_exclusion);
        penaltyViewB = (TextView) findViewById(team_b_penalty);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("strNameTeamA", nameTeamA.getText().toString());
        savedInstanceState.putString("strNameTeamB", nameTeamB.getText().toString());
        savedInstanceState.putInt("scoreA", scoreTeamA);
        savedInstanceState.putInt("scoreB", scoreTeamB);
        savedInstanceState.putInt("cornerA", cornerTeamA);
        savedInstanceState.putInt("cornerB", cornerTeamB);
        savedInstanceState.putInt("foulA", foulTeamA);
        savedInstanceState.putInt("foulB", foulTeamB);
        savedInstanceState.putInt("exclusionA", exclusionTeamA);
        savedInstanceState.putInt("exclusionB", exclusionTeamB);
        savedInstanceState.putInt("penaltyA", penaltyTeamA);
        savedInstanceState.putInt("penaltyB", penaltyTeamB);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int scoreA = savedInstanceState.getInt("scoreA");
        int scoreB = savedInstanceState.getInt("scoreB");
        int cornerA = savedInstanceState.getInt("cornerA");
        int cornerB = savedInstanceState.getInt("cornerB");
        int foulA = savedInstanceState.getInt("foulA");
        int foulB = savedInstanceState.getInt("foulB");
        int exclusionA = savedInstanceState.getInt("exclusionA");
        int exclusionB = savedInstanceState.getInt("exclusionB");
        int penaltyA = savedInstanceState.getInt("penaltyA");
        int penaltyB = savedInstanceState.getInt("penaltyB");

        strNameTeamA = savedInstanceState.getString("strNameTeamA");
        strNameTeamB = savedInstanceState.getString("strNameTeamB");

        displayScoreForTeamA (scoreA);
        scoreTeamA = scoreA;

        displayScoreForTeamB (scoreB);
        scoreTeamB = scoreB;

        displayCornerForTeamA(cornerA);
        cornerTeamA = cornerA;

        displayCornerForTeamB(cornerB);
        cornerTeamB = cornerB;

        displayFoulForTeamA(foulA);
        foulTeamA = foulA;

        displayFoulForTeamB(foulB);
        foulTeamB = foulB;

        displayExclusionForTeamA(exclusionA);
        exclusionTeamA = exclusionA;

        displayExclusionForTeamB(exclusionB);
        exclusionTeamB = exclusionB;

        displayPenaltyForTeamA(penaltyA);
        penaltyTeamA = penaltyA;

        displayPenaltyForTeamB(penaltyB);
        penaltyTeamB = penaltyB;

    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Increase the corners for Team A by 1.
     */
    public void addCornerForTeamA(View v) {
        cornerTeamA = cornerTeamA + 1;
        displayCornerForTeamA(cornerTeamA);
    }

    /**
     * Displays corners for Team A.
     */
    public void displayCornerForTeamA(int corner) {
        cornerViewA.setText(String.valueOf(corner));
    }

    /**
     * Increase the fouls for Team A by 1.
     */
    public void addFoulForTeamA(View v) {
        foulTeamA = foulTeamA + 1;
        displayFoulForTeamA(foulTeamA);
    }

    /**
     * Displays fouls for Team A.
     */
    public void displayFoulForTeamA(int foul) {
        foulViewA.setText(String.valueOf(foul));
    }

    /**
     * Increase the Exclusions for Team A by 1.
     */
    public void addExclusionForTeamA(View v) {
        exclusionTeamA = exclusionTeamA + 1;
        displayExclusionForTeamA(exclusionTeamA);
    }

    /**
     * Displays Exclusions for Team A.
     */
    public void displayExclusionForTeamA(int exclusion) {
        exclusionViewA.setText(String.valueOf(exclusion));
    }

    /**
     * Increase the Penalties for Team A by 1.
     */
    public void addPenaltyForTeamA(View v) {
        penaltyTeamA = penaltyTeamA + 1;
        displayPenaltyForTeamA(penaltyTeamA);
    }

    /**
     * Displays Penalties for Team A.
     */
    public void displayPenaltyForTeamA(int penalty) {
        penaltyViewA.setText(String.valueOf(penalty));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }
    /**
     * Increase the corners for Team B by 1.
     */
    public void addCornerForTeamB(View v) {
        cornerTeamB = cornerTeamB + 1;
        displayCornerForTeamB(cornerTeamB);
    }

    /**
     * Displays corners for Team B.
     */
    public void displayCornerForTeamB(int corner) {
        cornerViewB.setText(String.valueOf(corner));
    }

    /**
     * Increase the fouls for Team B by 1.
     */
    public void addFoulForTeamB(View v) {
        foulTeamB = foulTeamB + 1;
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * Displays fouls for Team B.
     */
    public void displayFoulForTeamB(int foul) {
        foulViewB.setText(String.valueOf(foul));
    }

    /**
     * Increase the Exclusions for Team B by 1.
     */
    public void addExclusionForTeamB(View v) {
        exclusionTeamB = exclusionTeamB + 1;
        displayExclusionForTeamB(exclusionTeamB);
    }

    /**
     * Displays Exclusions for Team B.
     */
    public void displayExclusionForTeamB(int exclusion) {
        exclusionViewB.setText(String.valueOf(exclusion));
    }

    /**
     * Increase the Penalties for Team B by 1.
     */
    public void addPenaltyForTeamB(View v) {
        penaltyTeamB = penaltyTeamB + 1;
        displayPenaltyForTeamB(penaltyTeamB);
    }

    /**
     * Displays Penalties for Team B.
     */
    public void displayPenaltyForTeamB(int penalty) {
        penaltyViewB.setText(String.valueOf(penalty));
    }

    /**
     * Reset the score for both teams
     */
    public void resetScore(View v) {
        nameTeamA.setText(R.string.TeamA);
        nameTeamB.setText(R.string.TeamB);
        scoreTeamA = 0;
        cornerTeamA = 0;
        foulTeamA = 0;
        exclusionTeamA = 0;
        penaltyTeamA = 0;
        scoreTeamB = 0;
        cornerTeamB = 0;
        foulTeamB = 0;
        exclusionTeamB = 0;
        penaltyTeamB = 0;

        displayScoreForTeamA(scoreTeamA);
        displayCornerForTeamA(cornerTeamA);
        displayFoulForTeamA(foulTeamA);
        displayExclusionForTeamA(exclusionTeamA);
        displayPenaltyForTeamA(penaltyTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayCornerForTeamB(cornerTeamB);
        displayFoulForTeamB(foulTeamB);
        displayExclusionForTeamB(exclusionTeamB);
        displayPenaltyForTeamB(penaltyTeamB);
    }
}