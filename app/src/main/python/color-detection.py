import cv2
import numpy as np
def colorDetection(image_directory):
    image = cv2.imread(image_directory)
    image = cv2.resize(image, (300, 300))
    hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    minValue = np.array([90, 0, 25])
    maxValue = np.array([130, 255, 255])

    blue = 0
    green = 0
    red = 0
    total_pixels = 0

    mask = cv2.inRange(hsv, minValue, maxValue)
    result = cv2.bitwise_and(image, image, mask=mask)

    for i in range(result.shape[0]):
        for j in range(result.shape[1]):
            if (result[i][j] != [0, 0, 0]).any():
                blue += result[i][j][0]
                green += result[i][j][1]
                red += result[i][j][2]
                total_pixels += 1
    bgrAverage = ""
    try:
        if(blue != 0):
            blue = round(blue/total_pixels)
        if(green != 0):
            green = round(green/total_pixels)
        if(red != 0):
            red = round(red/total_pixels)
        bgrAverage = [blue, green, red]
        print("blue: " + str(bgrAverage[0]) + " green: " + str(bgrAverage[1]) + " red: " + str(bgrAverage[2]) + " total_pixels: " + str(total_pixels) )
    except SyntaxError:
        bgrAverage = "error: there is no blue detected"
    cv2.imshow("image",image)
    cv2.imshow("mask", mask)
    cv2.imshow("result", result)
    cv2.waitKey(5000)

    return bgrAverage



