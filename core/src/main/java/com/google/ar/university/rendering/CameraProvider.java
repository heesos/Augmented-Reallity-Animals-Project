package com.google.ar.university.rendering;

import com.google.ar.university.common.TransformProvider;
import com.google.ar.university.math.Matrix;

/**
 * Required interface for a virtual camera.
 *
 * @hide
 */
public interface CameraProvider extends TransformProvider {
  boolean isActive();

  float getNearClipPlane();

  float getFarClipPlane();

  Matrix getViewMatrix();

  Matrix getProjectionMatrix();

  void updateTrackedPose(com.google.ar.core.Camera camera);
}
