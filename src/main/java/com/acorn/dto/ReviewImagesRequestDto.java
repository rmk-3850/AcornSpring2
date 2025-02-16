package com.acorn.dto;

import com.acorn.entity.ReviewImages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewImagesRequestDto {
    private String imageUrl;
    private Integer reviewNo;
	// toDto
	public static ReviewImagesRequestDto toDto(ReviewImages reviewImages) {
		return ReviewImagesRequestDto.builder()
				.imageUrl(reviewImages.getImageUrl())
				.reviewNo(reviewImages.getReviews().getNo())
				.build();
	}
}
