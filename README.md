- name: Build APK with Gradle
        env:
          ANDROID_HOME: /usr/local/lib/android/sdk
          ANDROID_SDK_ROOT: /usr/local/lib/android/sdk
        run: |
          chmod +x gradlew
          ./gradlew assembleDebug
