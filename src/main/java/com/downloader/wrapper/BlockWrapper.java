package com.downloader.wrapper;

import com.downloader.services.IBlock;
import lombok.Data;

@Data
public class BlockWrapper<N> {
    private N number;
    private IBlock internal;
}
