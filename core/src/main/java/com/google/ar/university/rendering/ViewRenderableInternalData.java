package com.google.ar.university.rendering;


import com.google.ar.university.resources.SharedReference;
import com.google.ar.university.utilities.AndroidPreconditions;

/**
 * Represents shared data used by {@link ViewRenderable}s for rendering. The data will be released
 * when all {@link ViewRenderable}s using this data are finalized.
 */

class ViewRenderableInternalData extends SharedReference {
  private final RenderViewToExternalTexture renderView;

  ViewRenderableInternalData(RenderViewToExternalTexture renderView) {
    this.renderView = renderView;
  }

  RenderViewToExternalTexture getRenderView() {
    return renderView;
  }

  @Override
  protected void onDispose() {
    AndroidPreconditions.checkUiThread();

    renderView.releaseResources();
  }
}
