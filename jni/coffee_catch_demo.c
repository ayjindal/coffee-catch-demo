#include "coffeecatch/coffeecatch.h"
#include "coffeecatch/coffeejni.h"

#include <android/log.h>


void dangerous_code()
{
    __android_log_write(ANDROID_LOG_INFO, "coffee-catch-demo", "Attempting to invoke dangerous code");
    char *ptr = NULL;
    *ptr = 'a';
    __android_log_write(ANDROID_LOG_ERROR, "coffee-catch-demo", "Should not reach here");
}

void Java_com_example_ayush_coffeecatchdemo_CoffeeCatchActivity_nativeCrashingFunction(JNIEnv *env, jobject obj)
{
    COFFEE_TRY_JNI(env, dangerous_code());
}