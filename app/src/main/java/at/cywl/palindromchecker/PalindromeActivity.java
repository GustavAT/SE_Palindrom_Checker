package at.cywl.palindromchecker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PalindromeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        Button buttonCheck = findViewById(R.id.buttonCheck);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView sourceField = findViewById(R.id.text_palindrome);
                String text = sourceField.getText().toString();
                String status = IsPalindrome(view.getContext(), text);

                ((TextView) findViewById(R.id.textview_status)).setText(status);
            }
        });
    }

    /**
     * Check if given string is a palindrome
     * @param target string to check
     * @return status message
     */
    protected static String IsPalindrome(Context ctx, String target) {
        if (target == null) return ctx.getString(R.string.text_target_is_null);

        target = target.trim();
        if (target.length() < 5) return ctx.getString(R.string.text_string_too_short);
        boolean result = target.equals(new StringBuilder(target).reverse().toString());
        return result
                ? ctx.getString(R.string.text_palindrome)
                : ctx.getString(R.string.text_not_palindrome);
    }
}
