interface Exportable {
void export();
}
class Tool implements Exportable {
public  void export() {// line n1
System.out.println("Tool::export");
}
}
class ReportTool extends Tool implements Exportable {
public void export() {// line n2
System.out.println("RTool::export");
}
public static void main(String[] args) {
Tool aTool = new ReportTool();
Tool bTool = new Tool();
callExport(aTool);
callExport(bTool);
}
public static void callExport(Exportable ex) {
ex.export();
}
}





