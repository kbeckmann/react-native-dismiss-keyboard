package se.pixelcity.dismisskeyboard;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

import java.util.Map;

public class DismissKeyboardModule extends ReactContextBaseJavaModule {

  public DismissKeyboardModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "DismissKeyboard";
  }

  @ReactMethod
  public void dismiss() {
    Log.d("DismissKeyboard", "dismissing keyboard");

      InputMethodManager imm = (InputMethodManager)getReactApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      if (imm.isAcceptingText()) {
        IBinder windowToken = getCurrentActivity().getWindow().getDecorView().getRootView().getWindowToken();
        imm.hideSoftInputFromWindow(windowToken, 0);
      }
  }
}
