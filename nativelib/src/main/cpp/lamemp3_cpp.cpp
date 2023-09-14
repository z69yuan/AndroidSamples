#include <jni.h>
#include <string>
#include "libmp3lame/lame.h"

static lame_global_flags *glf = NULL;

extern "C"
JNIEXPORT jstring JNICALL
Java_com_beancurdv_nativelib_LameUtil_stringFromJNI(JNIEnv *env, jclass clazz) {

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_beancurdv_nativelib_LameUtil_version(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF(get_lame_version());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_beancurdv_nativelib_LameUtil_init(JNIEnv *env, jclass clazz, jint in_sample_rate,
                                           jint in_channel, jint out_sample_rate, jint out_bitrate,
                                           jint quality) {
    // 先销毁，再重新创建
    if (glf != NULL) {
        lame_close(glf);
        glf = NULL;
    }

    glf = lame_init();
    lame_set_in_samplerate(glf, in_sample_rate);
    lame_set_num_channels(glf, in_channel);
    lame_set_out_samplerate(glf, out_sample_rate);
    lame_set_brate(glf, out_bitrate);
    lame_set_quality(glf, quality);
    lame_init_params(glf);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_beancurdv_nativelib_LameUtil_encode(JNIEnv *env, jclass clazz, jshortArray buffer_l_,
                                             jshortArray buffer_r_, jint samples,
                                             jbyteArray mp3buf_) {
    jshort *buffer_l = env->GetShortArrayElements(buffer_l_, NULL);
    jshort *buffer_r = env->GetShortArrayElements(buffer_r_, NULL);
    jbyte *mp3buf = env->GetByteArrayElements(mp3buf_, NULL);

    const jsize mp3buff_size = env->GetArrayLength(mp3buf_);
    int result = lame_encode_buffer(glf, buffer_l, buffer_r, samples, (u_char *) mp3buf,
                                    mp3buff_size);

    env->ReleaseShortArrayElements(buffer_l_, buffer_l, 0);
    env->ReleaseShortArrayElements(buffer_r_, buffer_r, 0);
    env->ReleaseByteArrayElements(mp3buf_, mp3buf, 0);
    return result;

}
extern "C"
JNIEXPORT jint JNICALL
Java_com_beancurdv_nativelib_LameUtil_flush(JNIEnv *env, jclass clazz, jbyteArray mp3buf_) {
    jbyte *mp3buff = env->GetByteArrayElements(mp3buf_, NULL);
    int mp3buff_size = env->GetArrayLength(mp3buf_);
    int result = lame_encode_flush(glf, (u_char *) mp3buff, mp3buff_size);
    env->ReleaseByteArrayElements(mp3buf_, mp3buff, 0);
    return result;
}
extern "C"
JNIEXPORT void JNICALL
Java_com_beancurdv_nativelib_LameUtil_close(JNIEnv *env, jclass clazz) {
    lame_close(glf);
    glf = NULL;
}
