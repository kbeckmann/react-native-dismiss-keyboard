#import "RNDismissKeyboardManager.h"
#import "RCTBridge.h"

@implementation RNDismissKeyboardManager

RCT_EXPORT_MODULE(DismissKeyboard);

RCT_EXPORT_METHOD(dismiss)
{
  NSLog(@"Dismissing keyboard");

  dispatch_async(dispatch_get_main_queue(), ^{
    UIApplication *app = [UIApplication sharedApplication];
    UIWindow * window = [app keyWindow];
    [window endEditing:YES];
  });
}

@end
