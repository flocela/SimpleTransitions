package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.end);
    final TextView yellowTextView = (TextView)findViewById(R.id.yellow);
    final TextView blueTextView   = (TextView)findViewById(R.id.blue);
    setupWindowAnimations();
    yellowTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(EndActivity.this, StartActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(EndActivity.this);
        startActivity(i, options.toBundle());
      }
    });
  }

  private void setupWindowAnimations () {
    Slide slideRight = new Slide();
    slideRight.setDuration(500);
    slideRight.setSlideEdge(Gravity.RIGHT);
    getWindow().setEnterTransition(slideRight);
    getWindow().setExitTransition(slideRight);
    /*slideRight.excludeTarget(android.R.id.statusBarBackground, true);
    slideRight.excludeTarget(android.R.id.navigationBarBackground, true);
    slideRight.excludeTarget(getResources().getIdentifier("action_bar_container", "id", "android"), true);*/
  }
}
