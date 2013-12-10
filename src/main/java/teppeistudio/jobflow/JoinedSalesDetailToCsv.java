package teppeistudio.jobflow;

import teppeistudio.modelgen.dmdl.csv.AbstractJoinedSalesDetailCsvOutputDescription;

public class JoinedSalesDetailToCsv extends
		AbstractJoinedSalesDetailCsvOutputDescription {

	@Override
	public String getBasePath() {
		return "firststep-out";
	}

	@Override
	public String getResourcePattern() {
		return "joined-data.csv";
	}

}
