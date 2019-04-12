package com.sanerly.movie.model;

/**
 * 作者：Sanerly
 * 时间；2019/4/2 18:17
 */
public class MoviesBean {

    /**
     * actorName1 : 于谦
     * actorName2 : 汤孟佳
     * btnText :
     * commonSpecial : 于谦变“恶霸”老师
     * directorName : 张栾
     * img : http://img5.mtime.cn/mt/2019/02/21/095918.47882172_1280X720X2.jpg
     * is3D : false
     * isDMAX : false
     * isFilter : false
     * isHot : false
     * isIMAX : false
     * isIMAX3D : false
     * isNew : false
     * length : 111
     * movieId : 261858
     * nearestShowtime : {"isTicket":true,"nearestCinemaCount":107,"nearestShowDay":1554105600,"nearestShowtimeCount":742}
     * preferentialFlag : false
     * rDay : 22
     * rMonth : 3
     * rYear : 2019
     * ratingFinal : 7.1
     * titleCn : 老师·好
     * titleEn : Song of Youth
     * type : 剧情
     * wantedCount : 250
     */

    private String actorName1;
    private String actorName2;
    private String btnText;
    private String commonSpecial;
    private String directorName;
    private String img;
    private boolean is3D;
    private boolean isDMAX;
    private boolean isFilter;
    private boolean isHot;
    private boolean isIMAX;
    private boolean isIMAX3D;
    private boolean isNew;
    private int length;
    private int movieId;
    private NearestShowtimeBean nearestShowtime;
    private boolean preferentialFlag;
    private int rDay;
    private int rMonth;
    private int rYear;
    private double ratingFinal;
    private String titleCn;
    private String titleEn;
    private String type;
    private int wantedCount;

    public String getActorName1() {
        return actorName1;
    }

    public void setActorName1(String actorName1) {
        this.actorName1 = actorName1;
    }

    public String getActorName2() {
        return actorName2;
    }

    public void setActorName2(String actorName2) {
        this.actorName2 = actorName2;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public String getCommonSpecial() {
        return commonSpecial;
    }

    public void setCommonSpecial(String commonSpecial) {
        this.commonSpecial = commonSpecial;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isIsDMAX() {
        return isDMAX;
    }

    public void setIsDMAX(boolean isDMAX) {
        this.isDMAX = isDMAX;
    }

    public boolean isIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean isFilter) {
        this.isFilter = isFilter;
    }

    public boolean isIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public boolean isIsIMAX() {
        return isIMAX;
    }

    public void setIsIMAX(boolean isIMAX) {
        this.isIMAX = isIMAX;
    }

    public boolean isIsIMAX3D() {
        return isIMAX3D;
    }

    public void setIsIMAX3D(boolean isIMAX3D) {
        this.isIMAX3D = isIMAX3D;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public NearestShowtimeBean getNearestShowtime() {
        return nearestShowtime;
    }

    public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
        this.nearestShowtime = nearestShowtime;
    }

    public boolean isPreferentialFlag() {
        return preferentialFlag;
    }

    public void setPreferentialFlag(boolean preferentialFlag) {
        this.preferentialFlag = preferentialFlag;
    }

    public int getRDay() {
        return rDay;
    }

    public void setRDay(int rDay) {
        this.rDay = rDay;
    }

    public int getRMonth() {
        return rMonth;
    }

    public void setRMonth(int rMonth) {
        this.rMonth = rMonth;
    }

    public int getRYear() {
        return rYear;
    }

    public void setRYear(int rYear) {
        this.rYear = rYear;
    }

    public double getRatingFinal() {
        return ratingFinal;
    }

    public void setRatingFinal(double ratingFinal) {
        this.ratingFinal = ratingFinal;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }

    public static class NearestShowtimeBean {
        /**
         * isTicket : true
         * nearestCinemaCount : 107
         * nearestShowDay : 1554105600
         * nearestShowtimeCount : 742
         */

        private boolean isTicket;
        private int nearestCinemaCount;
        private int nearestShowDay;
        private int nearestShowtimeCount;

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public int getNearestCinemaCount() {
            return nearestCinemaCount;
        }

        public void setNearestCinemaCount(int nearestCinemaCount) {
            this.nearestCinemaCount = nearestCinemaCount;
        }

        public int getNearestShowDay() {
            return nearestShowDay;
        }

        public void setNearestShowDay(int nearestShowDay) {
            this.nearestShowDay = nearestShowDay;
        }

        public int getNearestShowtimeCount() {
            return nearestShowtimeCount;
        }

        public void setNearestShowtimeCount(int nearestShowtimeCount) {
            this.nearestShowtimeCount = nearestShowtimeCount;
        }
    }
}
