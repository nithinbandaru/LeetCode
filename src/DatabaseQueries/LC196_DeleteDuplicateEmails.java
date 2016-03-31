package DatabaseQueries;

public class LC196_DeleteDuplicateEmails {

	public static void main(String[] args) {

		String query = "Delete p from person p, person q where p.Email = q.Email and p.Id > q.Id";
		
		System.out.println(query);
		
	}

}
