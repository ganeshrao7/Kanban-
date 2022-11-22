package com.niit.model;

public class Image {
    private String imageName;
    private String imageURL;

    public Image(String imageName, String imageURL) {
        this.imageName = imageName;
        this.imageURL = imageURL;
    }

    public Image() {
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageName='" + imageName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
