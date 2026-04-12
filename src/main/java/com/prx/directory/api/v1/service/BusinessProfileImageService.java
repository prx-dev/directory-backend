package com.prx.directory.api.v1.service;

import com.prx.commons.services.cloudflare.exception.ImageUploadException;
import com.prx.commons.services.cloudflare.exception.ImageValidationException;
import com.prx.commons.services.cloudflare.service.ImageService;
import com.prx.commons.services.cloudflare.to.ImageUploadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * BusinessProfileImageService defines the storage contract for business profile images.
 * Extends {@link ImageService} so implementations are also valid Spring beans for the
 * {@code ImageApi} default-method delegation.
 */
public interface BusinessProfileImageService extends ImageService {

    /**
     * Uploads an image for the given business, stores it in Cloudflare R2, and persists
     * the resulting public URL in {@code business.profile_image_ref}.
     *
     * @param businessId  UUID of the business to associate the image with
     * @param image       raw image bytes
     * @param contentType MIME type of the image (e.g. {@code image/jpeg})
     * @return 201 Created with {@link ImageUploadResponse}, or 404 if the business is not found
     */
    default ResponseEntity<ImageUploadResponse> uploadForBusiness(UUID businessId, byte[] image, String contentType)
            throws ImageValidationException, ImageUploadException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
