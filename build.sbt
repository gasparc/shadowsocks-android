import android.Keys._

import android.Dependencies.{apklib,aar}

android.Plugin.androidBuild

platformTarget in Android := "android-19"

name := "shadowsocks"

compileOrder in Compile := CompileOrder.JavaThenScala

resolvers += "JRAF" at "http://JRAF.org/static/maven/2"

resolvers += "madeye private releases" at "http://madeye-maven-repository.googlecode.com/git/"

libraryDependencies ++= Seq(
  "dnsjava" % "dnsjava" % "2.1.5",
  "org.scalaj" %% "scalaj-http" % "0.3.10",
  "commons-net" % "commons-net" % "3.3",
  "com.google.zxing" % "android-integration" % "2.2",
  "com.jcraft" % "jzlib" % "1.0.7",
  "com.jcraft" % "jsch" % "0.1.43-1"  
)

libraryDependencies ++= Seq(
  "net.simonvt.menudrawer" % "menudrawer" % "3.0.6",
  "com.google.android.gms" % "play-services" % "5.0.89",
  "com.android.support" % "support-v4" % "19.1.0"
)

libraryDependencies ++= Seq(
  "de.keyboardsurfer.android.widget" % "crouton" % "1.8.4" exclude("com.google.android", "support-v4"),
  "com.nostra13.universalimageloader" % "universal-image-loader" % "1.8.4",
  "com.j256.ormlite" % "ormlite-core" % "4.47",
  "com.j256.ormlite" % "ormlite-android" % "4.47"
)

proguardOptions in Android ++= Seq("-keep class android.support.v4.app.** { *; }",
          "-keep interface android.support.v4.app.** { *; }",
          "-keep class com.actionbarsherlock.** { *; }",
          "-keep interface com.actionbarsherlock.** { *; }",
          "-keep class org.jraf.android.backport.** { *; }",
          "-keep class com.github.shadowsocks.** { *; }",
          "-keep class * extends com.j256.ormlite.** { *; }",
		  "-keep class com.jcraft.jsch.** { *; }",
          "-keepattributes *Annotation*",
          "-dontwarn org.xbill.**",
		  "-dontwarn org.ietf.jgss.**",
          "-dontwarn com.actionbarsherlock.**")
