package com.google.ar.university.common;

import com.google.ar.university.math.Matrix;

/**
 * Interface for providing information about a 3D transformation. See {@link
 * com.google.ar.university.Node}.
 *
 * @hide
 */
public interface TransformProvider {
  Matrix getWorldModelMatrix();
}
