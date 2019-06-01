//
//  ETSTableHeaderFooter.swift
//  ETSMobile
//
//  Created by Emmanuel Proulx on 2018-12-18.
//  Copyright © 2018 ApplETS. All rights reserved.
//

import UIKit

class ETSTableHeaderFooter: UITableViewHeaderFooterView {

    static let reuseIdentifer = "ETSHeader"
    let customLabel = UILabel.init()
    
    override public init(reuseIdentifier: String?) {
        super.init(reuseIdentifier: reuseIdentifier)
        
        customLabel.font = UIFont.preferredFont(forTextStyle: .title1)
        customLabel.translatesAutoresizingMaskIntoConstraints = false
        customLabel.textColor = UIColor.white
        self.contentView.addSubview(customLabel)
        
        let margins = contentView.layoutMarginsGuide
        customLabel.leadingAnchor.constraint(equalTo: margins.leadingAnchor).isActive = true
        customLabel.trailingAnchor.constraint(equalTo: margins.trailingAnchor).isActive = true
        customLabel.topAnchor.constraint(equalTo: margins.topAnchor).isActive = true
        customLabel.bottomAnchor.constraint(equalTo: margins.bottomAnchor).isActive = true
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

}