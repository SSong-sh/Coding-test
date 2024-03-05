package xxx;

public class query {
	public static void main(String[] args) {
		for (int i= 76; i< 101; i++) {			
			System.out.printf("insert into tblclassregistration (seq, studentNum, openCurriculumNum, graduateDate) "
					+ "values ((select nvl(max(seq), 0) + 1 from tblclassregistration), %d, 4, to_date('2024-07-31', 'YYYY-MM-DD'));",i);
			
			System.out.println();
		}
	}
}
