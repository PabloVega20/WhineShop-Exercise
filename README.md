List<Wine> findAllByOrderByRatingDesc();
	List<Wine> findAllByOrderByPriceDesc();
	
	
	
	public List<Wine> findAllByOrderByRatingDesc() {
		return wineRepository.findAllByOrderByRatingDesc();
	}
	
	public List<Wine> findAllByOrderByPriceDesc() {
		return wineRepository.findAllByOrderByPriceDesc();
	}
	
