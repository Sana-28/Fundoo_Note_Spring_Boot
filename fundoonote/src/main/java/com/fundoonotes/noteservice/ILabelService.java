package com.fundoonotes.noteservice;

import java.util.List;

public interface ILabelService {

	void createLabel(Label label, int userId);
	void deleteLabel(int id);
	List<LabelResDto> getLabels(int userId);
}
