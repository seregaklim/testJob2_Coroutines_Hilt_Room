
buildscript {

    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:4.1.3")
        // Hilt Related
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.49")

    }
}


plugins { id("com.android.application") version "8.1.0" apply false
    id ("com.android.library") version "8.1.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false


}