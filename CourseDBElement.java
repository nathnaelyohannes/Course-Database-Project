public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseID;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructorName;

    public CourseDBElement(String id, int crn, int credits, String room, String instructor) {
        this.courseID = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = room;
        this.instructorName = instructor;
    }
    
    public CourseDBElement() {
        this.courseID = "";
        this.crn = 0;
        this.credits = 0;
        this.roomNum = "";
        this.instructorName = "";
    }
    
    public String getID() { 
    	return courseID; 
    }
    public int getCRN() { 
    	return crn;
    }
    public int getCredits() {
    	return credits; 
    }
    public String getRoomNum() { 
    	return roomNum; 
    }
    public String getInstructorName() { 
    	return instructorName; 
    }

    public void setID(String id) { 
    	this.courseID = id; 
    }
    public void setCRN(int crn) { 
    	this.crn = crn; 
    }
    public void setCredits(int credits) { 
    	this.credits = credits; 
    }
    public void setRoomNum(String roomNum) { 
    	this.roomNum = roomNum; 
    }
    public void setInstructorName(String instructorName) { 
    	this.instructorName = instructorName;
    }

    @Override
    public int hashCode() {
        return crn;
    }

    @Override
    public int compareTo(CourseDBElement element) {
        return this.crn - element.crn;
    }

    @Override
    public String toString() {
        return "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructorName + " Room:" + roomNum;
    }
}
