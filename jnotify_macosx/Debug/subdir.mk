# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
$(ROOT)/net_contentobjects_jnotify_macosx_JNotify_macosx.c \
$(ROOT)/net_contentobjects_jnotify_macosx_JNotifyAdapterMacOSX_JNFile.c

OBJS += \
./net_contentobjects_jnotify_macosx_JNotify_macosx.o \
./net_contentobjects_jnotify_macosx_JNotifyAdapterMacOSX_JNFile.o

DEPS += \
${addprefix ./, \
net_contentobjects_jnotify_macosx_JNotify_macosx.d \
net_contentobjects_jnotify_macosx_JNotifyAdapterMacOSX_JNFile.d \
}


# Each subdirectory must supply rules for building sources it contributes
%.o: $(ROOT)/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	@echo gcc -I/System/Library/Frameworks/JavaVM.framework/Headers -O0 -g3 -Wall -c -fmessage-length=0 -fPIC -arch ppc -arch ppc64 -arch i386 -arch x86_64 -isysroot /Developer/SDKs/MacOSX10.5.sdk -mmacosx-version-min=10.5 -o $@ $<
	@gcc -I/System/Library/Frameworks/JavaVM.framework/Headers -O0 -g3 -Wall -c -fmessage-length=0 -fPIC -arch ppc -arch ppc64 -arch i386 -arch x86_64 -isysroot /Developer/SDKs/MacOSX10.5.sdk -mmacosx-version-min=10.5 -o $@ $< && \
	echo $(dir $@)"`gcc -MM -MG -P -w -I/System/Library/Frameworks/JavaVM.framework/Headers -O0 -g3 -Wall -c -fmessage-length=0 -fPIC  $<`" > $(@:%.o=%.d)
	@echo 'Finished building: $<'
	@echo ' '


