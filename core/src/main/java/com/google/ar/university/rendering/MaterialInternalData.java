package com.google.ar.university.rendering;

import com.google.ar.university.resources.SharedReference;

abstract class MaterialInternalData extends SharedReference {
  abstract com.google.android.filament.Material getFilamentMaterial();
}
