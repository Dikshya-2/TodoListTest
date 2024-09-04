package dk.tec.todolistfinal;

import android.content.Context;
import android.widget.Toast;

public class TodoHelper {
    public static int calculateStreakBonus(int streak) {
        // Implementation here
        return streak * 10; // Example
    }

    public static int calculateComboBoostXP(int combo) {
        // Implementation here
        return combo * 5; // Example
    }

    public static void showXPToast(Context context, int xp) {
        Toast.makeText(context, "XP Earned: " + xp, Toast.LENGTH_SHORT).show();
    }

    public static void showTaskNotification(Context context, String taskName) {
        // Notification logic here
    }
}
