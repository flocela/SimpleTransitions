package flobee.cognatesproofofconcept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start);
    final TextView yellowTextView  = (TextView)findViewById(R.id.yellow);
    final TextView blueTextView    = (TextView)findViewById(R.id.blue);
    //setupWindowAnimations();
    yellowTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      Intent i = new Intent(StartActivity.this, EndActivity.class);
        startActivity(i);
      //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
      //  StartActivity.this,
      //  new Pair<View, String>(yellowTextView, "yellow_diagonal"),
      //  new Pair<View, String>(blueTextView, "blue_diagonal"));
      //startActivity(i, options.toBundle());
      }
    });
  }

  private void setupWindowAnimations () {
    //Slide slideLeft = new Slide();
    //slideLeft.setDuration(500);
    //slideLeft.setSlideEdge(Gravity.LEFT);
    //slideLeft.excludeTarget(android.R.id.statusBarBackground, true);
    //slideLeft.excludeTarget(android.R.id.navigationBarBackground, true);
    //slideLeft.excludeTarget(getResources().getIdentifier("action_bar_container", "id", "android"), true);
    //getWindow().setEnterTransition(slideLeft);// put slideLeft as argument for whole Activity View to move
    //getWindow().setExitTransition(slideLeft);// put slideLeft as argument for whole Activity View to move
  }
}
/* Introduction:
   Look at the end.xml and start.xml layouts. The idea is that pressing the yellow and
   blue textboxes starts the new activity, where the yellow and blue textboxes switch places.
   Note StartActivity has a click listener on the yellow text view.
   Note EndActivity has a click listener on the blue text view.

   Note inside of styles.xml:
    <item name="android:windowContentTransitions">false</item>
   Note not inside of styles.xml.
    <item name="android:windowActivityTransitions">true</item>
 */

/* Case 1: No transition.
   Do not pass any options to startActivity().
   EndActivity and StartActivity pop on when clicking Yellow and Blue TextViews.
   Intent i = new Intent(StartActivity.this, EndActivity.class);
   startActivity(i);
   setupWindowAnimations() method is commented out.
 */

/* Case 2: Android chooses the transition.
   Uncomment ActivityOptions, putting in new pairs.
   Add ActivityOptions to startActivity() by uncommenting Intent and ActivityOptions.
   startActivity(i, options.toBundle());
   And comment out plain startActivity(i);
   Note, orange, grey and basically the whole activity blinks before the transistion.
   Doesn't matter if I add "<item name=android:windowActivityTransitions>true</item>",
   still blinks.
 */

 /* Case 3: Set enter and exit transitions for window as null.
    Uncomment setupWindowAnimations() call in line 19.
    Uncomment getWindow.setEnterTransitions(null); and
    Uncomment getWindow.setExitTransitions(null);
    Smooth diagonal transition of yellow and blue text boxes. The whole
    activity doesn't blink anymore. Only transition is from the
    ActivityOptions.
  */

  /* Case 4: Set enter and exit transitions for window as slide left.
     Uncomment first three lines in setupWindowAnimations() and
     uncomment last two lines in setupWindowAnimations(). So uncomment all lines
     except lines that have excludeTarget() in them.
     Whole window slides in and out from left except for predetermined
     yellow and blue text boxes from the ActivityOptions.
   */

  /* Case 5: Exclude action bar and navigation bar from sliding.
     Uncomment excludeTarget() lines.
     Yellow and blue text boxes still have diagonal transitions.
     Orange and grey text boxes slide from left and right.
     Everything else stays in place.
   */