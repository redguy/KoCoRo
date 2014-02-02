(ns kocoro.views.room
  (:import (javax.imageio ImageIO)
           (java.awt Font)
           (java.io File ByteArrayOutputStream ByteArrayInputStream)))

(defn setup []
  (System/setProperty "java.awt.headless" "true"))

(defn set-font [ gfx & {:keys [name style size] :or {name "TimesRoman", style Font/PLAIN, size 10}} ]
  (.setFont gfx (Font. name style size)))

(defn image [room]
  (setup)
  (let [file (File. "/tmp/image.png")
        image (ImageIO/read file)
        bos (ByteArrayOutputStream. 256)
        g (.createGraphics image)]
    (set-font g :size 40)
    (.drawString g room 100 200)
    (ImageIO/write image "png" bos)
    (ByteArrayInputStream. (.toByteArray bos))))
