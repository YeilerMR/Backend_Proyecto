package cr.ac.una.proyecto_progra4_backend.Request;

public class RequestPage {
    private int page;
    private int pageSize;
    public RequestPage() {
    }
    public RequestPage(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}
