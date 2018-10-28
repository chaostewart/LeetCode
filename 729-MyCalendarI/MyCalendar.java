class MyCalendar {
    List<int[]> bookings; 
    public MyCalendar() {
        bookings = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        int lo = 0, hi = bookings.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int[] bk = bookings.get(mid);
            if (bk[0] == start) 
                return false;
            else if (bk[0] > start)
                hi = mid - 1;
            else
                lo = mid + 1;        
        }
        // at the end of while-loop, lo is the index at which we'd like to insert the new booking
        // bookings[lo-1].start < new_booking.start <  bookings[lo].start
        // but still need to check: bookings[lo-1].end <= new_booking.start < new_booking.end <=  bookings[lo].start
        
        // new booking will overlap will bookings[lo-1]
        // note: when lo = 0, new booking will be inserted at the front of the list
        if (lo > 0 && start < bookings.get(lo-1)[1])
            return false;
        // new booking will overlap will bookings[lo]
        // note: when lo = bookings.size(), new booking will be added at the end of the list
        if (lo < bookings.size() && end > bookings.get(lo)[0])
            return false;
        
        bookings.add(lo, new int[] {start, end});
        return true; 
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */