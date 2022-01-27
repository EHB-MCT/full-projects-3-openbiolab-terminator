import cv2
import numpy as np
def colorDetection(imagedirectory):
    image = cv2.imread(imagedirectory)
    image = cv2.resize(image, (300,300))
    hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    minValue = np.array([100, 50, 50])
    maxValue = np.array([130, 255, 255])

    blue = 0
    green = 0
    red = 0
    totalpixels = 0

    mask = cv2.inRange(hsv, minValue, maxValue)
    result = cv2.bitwise_and(image, image, mask=mask)

    for i in range(result.shape[0]):
        for j in range(result.shape[1]):
            if (result[i][j] != [0, 0, 0]).any():
                blue += result[i][j][0]
                green += result[i][j][1]
                red += result[i][j][2]
                totalpixels += 1

    if( blue != 0 and green != 0 and red != 0 ):
        blue = round(blue/totalpixels)
        green = round(green/totalpixels)
        red = round(red/totalpixels)
        bgrAverage = [blue, green, red]
    else:
        bgrAverage = "error: no blue detected"

    print("blue: " + str(bgrAverage[0]) + " green: " + str(bgrAverage[1]) + " red: " + str(bgrAverage[2]) + " totalpixels: " + str(totalpixels) )

    return bgrAverage


#ColorDetection('img/img2.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img3.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img4.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img5.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img6.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img7.jpg', [100, 50, 50], [130, 255, 255])
#ColorDetection('img/img8.jpg', [100, 50, 50], [130, 255, 255])

