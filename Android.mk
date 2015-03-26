LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := coffee_catch_demo
LOCAL_SRC_FILES := coffee_catch_demo.c coffeecatch/coffeecatch.c coffeecatch/coffeejni.c
LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog

# ARM (coffeecatch)
LOCAL_CFLAGS := -funwind-tables -Wl,--no-merge-exidx-entries

include $(BUILD_SHARED_LIBRARY)