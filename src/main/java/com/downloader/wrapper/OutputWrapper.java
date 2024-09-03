package com.downloader.wrapper;

import com.downloader.services.IOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OutputWrapper implements IOutput {
    private IOutput output;

    public OutputWrapper(IOutput output) {
        this.output = output;
    }
}
