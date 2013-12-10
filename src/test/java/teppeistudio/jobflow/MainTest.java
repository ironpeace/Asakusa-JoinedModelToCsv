package teppeistudio.jobflow;

import org.junit.Test;

import teppeistudio.modelgen.dmdl.model.ItemMaster;
import teppeistudio.modelgen.dmdl.model.JoinedSalesDetail;
import teppeistudio.modelgen.dmdl.model.SalesDetail;

import com.asakusafw.testdriver.JobFlowTester;


public class MainTest {

	@Test
	public void test(){
		JobFlowTester tester = new JobFlowTester(getClass());
		
		tester
			.input("ItemMaster", ItemMaster.class)
			.prepare("item_master.xls#input");
		
		tester
			.input("SalesDetail", SalesDetail.class)
			.prepare("sales_detail.xls#input");

		tester
			.output("joinedSalesDetail", JoinedSalesDetail.class)
			.verify("joined_sales_detail.xls#output", "joined_sales_detail.xls#rule");
		
		tester.runTest(MainJobFlow.class);
	}
}
