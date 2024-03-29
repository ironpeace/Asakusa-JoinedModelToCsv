package teppeistudio.jobflow;

import teppeistudio.modelgen.dmdl.model.ItemMaster;
import teppeistudio.modelgen.dmdl.model.JoinedSalesDetail;
import teppeistudio.modelgen.dmdl.model.SalesDetail;
import teppeistudio.operator.JoinOperatorFactory;
import teppeistudio.operator.JoinOperatorFactory.JoinedData;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

@JobFlow(name="MainJobFlow")
public class MainJobFlow extends FlowDescription {

	final In<ItemMaster> itemMaster;
	final In<SalesDetail> salesDetail;
	final Out<JoinedSalesDetail> joinedSalesDetail;

	public MainJobFlow(
			@Import(name="ItemMaster", description=ItemMasterFromCsv.class)
			In<ItemMaster> itemMaster,
			@Import(name="SalesDetail", description=SalesDetailFromCsv.class)
			In<SalesDetail> salesDetail,
			@Export(name="joinedSalesDetail", description=JoinedSalesDetailToCsv.class)
			Out<JoinedSalesDetail> joinedSalesDetail
			){

		this.itemMaster = itemMaster;
		this.salesDetail = salesDetail;
		this.joinedSalesDetail = joinedSalesDetail;
	}
	
	@Override
	protected void describe() {
		JoinOperatorFactory op = new JoinOperatorFactory();
		CoreOperatorFactory cp = new CoreOperatorFactory();
		
		JoinedData joinedData = op.joinedData(this.itemMaster, this.salesDetail);
		cp.stop(joinedData.missed);
		
		joinedSalesDetail.add(joinedData.joined);
	}

}
